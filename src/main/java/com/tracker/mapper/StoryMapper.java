package com.tracker.mapper;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.dto.StoryDto;
import com.tracker.entities.Issue;
import com.tracker.entities.Story;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoryMapper {
    StoryMapper INSTANCE = Mappers.getMapper(StoryMapper.class);

    Story dtoToEntity(StoryDto storyDto);

    default StoryDto entityToDto(Story story) {
        if ( story == null ) {
            return null;
        }
        StoryDto storyDto = new StoryDto();
        storyDto.setTitle( story.getTitle() );
        storyDto.setDescription( story.getDescription() );
        if(story.getDeveloper()!=null)
        storyDto.setDevelopername( story.getDeveloper().getName());
        storyDto.setStatus(story.getStatus());
        storyDto.setEstimatedPointValue(story.getEstimatedPointValue());
        return storyDto;
    }
}
