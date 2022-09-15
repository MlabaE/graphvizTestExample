package org.example.xml.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.xml.parser.dto.RootDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateDotFile {

    public static final String JSON = """
            {
                "pageInfo": {
                        "pageName": "Homepage",
                        "logo": "https://www.example.com/logo.jpg"
                },
                "posts": [
                        {
                            "post_id": "0123456789",
                            "actor_id": "1001",
                            "author_name": "Jane Doe",
                            "post_title": "How to parse JSON in Java",
                            "comments": [],
                            "time_of_post": "1234567890"
                        }
                ]
            }""";

    public static void main(String[] args) throws IOException {
        var objectMapper = new ObjectMapper();
        var payload = objectMapper.readValue(JSON, RootDto.class);

        System.out.println(payload.getPageInfo().getPageName());

        var graph = new Digraph("test_Graph");
        graph.addNode(payload.getPageInfo().getPageName());
        payload.getPosts().forEach(post -> {
            graph.addNode(post.getPostId());
            graph.link(payload.getPageInfo().getPageName(), post.getPostId());

        });
        graph.generate("graph.dot");

        String [] command = {"dot.exe","-Tsvg graph.dot > output.svg"};
        var process = Runtime.getRuntime().exec(command,null);
        var stdin = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(stdin.readLine());
    }
}
