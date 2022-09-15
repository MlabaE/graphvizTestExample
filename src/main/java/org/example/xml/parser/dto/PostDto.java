package org.example.xml.parser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
@JsonProperty("post_id")
    private String postId;
    @JsonProperty("actor_id")
    private String actorId;
    @JsonProperty("author_name")
    private String name;
    @JsonProperty("post_title")
    private String postTitle;
    @JsonProperty("time_of_post")
    private String timeOfPost;
    private List<CommentDto> comments;

}
