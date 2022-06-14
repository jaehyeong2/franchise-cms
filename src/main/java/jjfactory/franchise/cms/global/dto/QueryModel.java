package jjfactory.franchise.cms.global.dto;

import jjfactory.franchise.cms.global.util.StringToLocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QueryModel {
    private String query;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public QueryModel(String query,String startDate,String endDate){
        this.query = query;
        this.startDate = StringToLocalDateTime.convertLocalDateTime(startDate);
        this.endDate = StringToLocalDateTime.convertLocalDateTime(endDate);
    }
}
