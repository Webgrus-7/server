package com.solveus.service;


import com.solveus.domain.dto.FollowDto;
import com.solveus.domain.entity.FollowRelation;
import com.solveus.domain.entity.User;
import com.solveus.domain.repository.FollowRepository;
import com.solveus.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowDto makeFollowDto(FollowRelation relation) {
        FollowDto followDto = FollowDto.builder()
                .id(relation.getId())
                .follower(relation.getFollower().getUserID())
                .following(relation.getFollowing().getUserID())
                .build();

        return followDto;
    }

    @Transactional
    public FollowDto newFollowing(User follower, String following_id) {
        // folloewr - 하는 사람, following - 당하는 사람

//        User follower = userRepository.findById(follower_id)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자(팔로워)입니다."));
        User following = userRepository.findByUserID(following_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자(팔로잉)입니다."));


        // 1. 이미 팔로잉 했는지 확인
        Optional<FollowRelation> alreadyFollowing = followRepository.findByFollowerAndFollowing(follower,following);
        if(alreadyFollowing.isPresent()) {
            throw new IllegalArgumentException("이미 팔로잉했습니다.");
        }
            // 팔로워 - 팔로잉 수 + 1
        follower.setFollowing_count(follower.getFollowing_count() + 1);
        userRepository.save(follower);
        // 팔로잉 - 팔로워 수 + 1
        following.setFollower_count(following.getFollower_count() + 1);
        userRepository.save(following);
        // 팔로우 - 팔로잉 관계 추가
        FollowRelation newRelation = FollowRelation.builder()
                .follower(follower)
                .following(following)
                .build();
        followRepository.save(newRelation);
        return makeFollowDto(newRelation);
    }

}
