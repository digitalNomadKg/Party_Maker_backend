package com.party.maker.demo.service;

import com.party.maker.demo.domain.EventCategory;
import com.party.maker.demo.dto.EventCategoryDto;
import com.party.maker.demo.repository.EventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventCategoryService {
    private final EventCategoryRepository eventCategoryRepository;
    private Boolean isAvailable = true;

    @Autowired
    public EventCategoryService(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    public Iterable<EventCategoryDto> getAllCategories() {
        List<EventCategory> eventCategoryList = (List<EventCategory>) eventCategoryRepository.findAll();
        List<EventCategoryDto> categoryDtos = new ArrayList<>();

        for(EventCategory category: eventCategoryList){
            EventCategoryDto categoryDto = convertEventCategoryToEventCategoryDto(category);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    private EventCategoryDto convertEventCategoryToEventCategoryDto(EventCategory category) {
        EventCategoryDto categoryDto = new EventCategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setBudget(category.getBudget());
        categoryDto.setCategoryStatus(category.getCategoryStatus());
        categoryDto.setCreatedDate(category.getCreatedDate());
        categoryDto.setEventName(category.getEventName());
        categoryDto.setUpdatedDate(category.getUpdatedDate());
        return categoryDto;
    }

    public EventCategory save(EventCategoryDto categoryDto) {
        EventCategory eventCategory = convertEventCategoryDtoToEventCategory(categoryDto);
        return eventCategoryRepository.save(eventCategory);
    }

    private EventCategory convertEventCategoryDtoToEventCategory(EventCategoryDto categoryDto) {
        EventCategory eventCategory = new EventCategory();
        eventCategory.setBudget(categoryDto.getBudget());
        eventCategory.setCategoryStatus(categoryDto.getCategoryStatus());
        eventCategory.setCreatedDate(categoryDto.getCreatedDate());
        eventCategory.setEventName(categoryDto.getEventName());
        eventCategory.setUpdatedDate(categoryDto.getUpdatedDate());
        eventCategory.setId(categoryDto.getId());
        return eventCategory;
    }

    public EventCategoryDto findById(Long id) {

        if(eventCategoryRepository.findById(id).isPresent()){
            EventCategory category = eventCategoryRepository.findById(id).get();
            return convertEventCategoryToEventCategoryDto(category);
        }
        isAvailable = false;
        return null;
    }

    public void delete(Long id){
        if(eventCategoryRepository.findById(id).isPresent()){
            eventCategoryRepository.deleteById(id);
        }
    }
}


