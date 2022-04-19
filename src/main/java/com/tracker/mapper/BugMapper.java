package com.tracker.mapper;

import com.tracker.dto.BugDto;
import com.tracker.dto.IssueDto;
import com.tracker.entities.Bug;
import com.tracker.entities.Issue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper

public interface BugMapper {
    BugMapper INSTANCE = Mappers.getMapper(BugMapper.class);
    Bug dtoToEntity(BugDto bugDto);

    default BugDto entityToDto(Bug bug) {
        if ( bug == null ) {
            return null;
        }
        BugDto bugDto = new BugDto();
        bugDto.setTitle( bug.getTitle() );
        bugDto.setDescription( bug.getDescription() );
        if(bug.getEstimatedPointValue()!=null)
        bugDto.setEstimatedPointValue(bug.getEstimatedPointValue());
        if(bug.getPriority()!=null)
            bugDto.setPriority(bug.getPriority());
        if(bug.getStatus()!=null)
            bugDto.setStatus(bug.getStatus());

        if(bug.getDeveloper()!=null)
        bugDto.setDevelopername( bug.getDeveloper().getName());
        return bugDto;
    }
}
