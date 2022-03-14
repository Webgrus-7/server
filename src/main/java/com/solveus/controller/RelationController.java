package com.solveus.controller;

import com.solveus.domain.dto.FollowDto;
import com.solveus.domain.entity.FollowRelation;
import com.solveus.domain.entity.User;
import com.solveus.service.AuthService;
import com.solveus.service.FollowService;
import com.solveus.service.ProblemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationService;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/relation")
public class RelationController {

    private final AuthService authService;
    private final ProblemService problemService;
    private final FollowService followService;
    // 팔로우 하기
    @RequestMapping(value = "/following/{userID}", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ACCESS_TOKEN", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class ),
            @ApiImplicitParam(name = "REFRESH_TOKEN", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class)
    })
    public ResponseEntity<FollowDto> following(HttpServletRequest request , @PathVariable("userID") String following) throws  Exception {
        User follower = authService.find_user(request);
        FollowDto relation = followService.newFollowing(follower,following);
        return ResponseEntity.status(HttpStatus.OK)
                .body(relation);
    }

    // 팔로우 취소하기

    // 팔로워 사용자 목록

    // 팔로잉 사용자 목록

    // 팔로워 사용자의 문제 목록

}
