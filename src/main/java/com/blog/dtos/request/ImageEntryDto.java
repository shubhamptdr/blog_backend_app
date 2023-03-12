package com.blog.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntryDto {

    private String description;

    private String dimensions;

    private int blogId;

}
