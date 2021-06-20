package com.bulbul.examportal.controller.exam;

import com.bulbul.examportal.entity.exam.Category;
import com.bulbul.examportal.entity.exam.SubCategory;
import com.bulbul.examportal.service.exam.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
@CrossOrigin("*")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    //add subcategory
    @PostMapping("/")
    public ResponseEntity<SubCategory> addSubCategory(@RequestBody SubCategory subCategory){
        SubCategory subCategory1 = this.subCategoryService.addSubCategory(subCategory);
        return ResponseEntity.ok(subCategory1);
    }

    //get subcategory
    @GetMapping("/{subCategoryId}")
    public SubCategory getSubCategory(@PathVariable("subCategoryId") Long subCategoryId){
        return this.subCategoryService.getSubCategory(subCategoryId);
    }

    //get all subcategories
    @GetMapping("/")
    public List<SubCategory> getSubCategories(){
        return this.subCategoryService.getSubCategories();
    }


    @GetMapping("/category/{categoryId}")
    public List<SubCategory> getSubCategoryOfCategory(@PathVariable("categoryId") Long categoryId){
        Category category = new Category();
        category.setCid(categoryId);
        return this.subCategoryService.getSubCategoryOfCategory(category);
    }

    @DeleteMapping("/{id}")
    public String deleteSubCategoryById(@PathVariable("id") Long subCatId){
        this.subCategoryService.deleteSubCategoryById(subCatId);
        return "Subcategory deleted successfully";
    }

}
