package com.bulbul.examportal.service.exam;

import com.bulbul.examportal.entity.exam.Category;
import com.bulbul.examportal.entity.exam.SubCategory;

import java.util.List;
import java.util.Set;

public interface SubCategoryService {

    SubCategory addSubCategory(SubCategory subCategory);

    SubCategory getSubCategory(Long subCategoryId);


    List<SubCategory> getSubCategories();

    void deleteSubCategoryById(Long subCatId);

    List<SubCategory> getSubCategoryOfCategory(Category category);
}
