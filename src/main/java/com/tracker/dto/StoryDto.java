package com.tracker.dto;

import com.tracker.enums.Status;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StoryDto extends IssueDto {

    private Integer estimatedPointValue;
    private Status status;

}
