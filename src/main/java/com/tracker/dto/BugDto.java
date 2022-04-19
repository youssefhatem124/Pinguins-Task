package com.tracker.dto;

import com.tracker.entities.Developer;
import com.tracker.enums.IssueType;
import com.tracker.enums.Priority;
import com.tracker.enums.Status;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BugDto extends IssueDto {
  //  private IssueType issueType;
    private Integer estimatedPointValue;
    private Status status;
    private Priority priority;
}
