package com.bulbul.examportal.service.impl.exam;

import com.bulbul.examportal.entity.exam.Category;
import com.bulbul.examportal.entity.exam.SubCategory;
import com.bulbul.examportal.repository.exam.SubCategoryRepository;
import com.bulbul.examportal.service.exam.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        return this.subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory getSubCategory(Long subCategoryId) {
        return this.subCategoryRepository.findById(subCategoryId).get();
    }

    @Override
    public List<SubCategory> getSubCategories() {
        return this.subCategoryRepository.findAll();
    }

    @Override
    public void deleteSubCategoryById(Long subCatId) {
        this.subCategoryRepository.deleteById(subCatId);
    }

    @Override
    public List<SubCategory> getSubCategoryOfCategory(Category category) {
        return this.subCategoryRepository.findByCategory(category);
    }


}
