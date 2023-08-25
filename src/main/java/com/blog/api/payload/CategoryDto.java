package com.blog.api.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDto {

    private long categoryId;
    private String categoryTitle;
    private String categoryDescription;



}
