package com.tracker.mapper;

import com.tracker.dto.IssueDto;
import com.tracker.entities.Issue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IssueMapper {

    IssueMapper INSTANCE = Mappers.getMapper(IssueMapper.class);

    Issue dtoToEntity(IssueDto issueDto);

    default IssueDto entityToDto(Issue issue) {
        if ( issue == null ) {
            return null;
        }

        IssueDto.IssueDtoBuilder issueDto = IssueDto.builder();

        issueDto.title( issue.getTitle() );
        issueDto.description( issue.getDescription() );

        if(issue.getDeveloper()!=null)
            issueDto.developername( issue.getDeveloper().getName());
        return issueDto.build();
    }



}
