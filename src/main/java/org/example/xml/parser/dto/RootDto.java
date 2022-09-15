package org.example.xml.parser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootDto {

    private PageDto pageInfo;
    private List<PostDto> posts;



}
