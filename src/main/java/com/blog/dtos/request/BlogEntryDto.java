package com.blog.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryDto {

    private String title;

    private String content;

    private int userId;

}
