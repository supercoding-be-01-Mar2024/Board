package com.example.github.web.DTO.post;

import com.example.github.repository.comment.Comment;
import com.example.github.repository.post.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsResponse {
    private Integer postId;
    private String title;
    private String name;
    private Integer likesCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월 dd일 HH시 mm분")
    private LocalDateTime createdAt;

    public PostsResponse(Integer postId, String title, String name, Long likesCount, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.name = name;
        this.likesCount = likesCount != null ? likesCount.intValue() : 0;
        this.createdAt = createdAt;
    }

    public PostsResponse(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.name = post.getName();
        this.likesCount = post.getLikeCnt() != null ? post.getLikeCnt() : 0;
        this.createdAt = post.getCreatedAt();
    }
}