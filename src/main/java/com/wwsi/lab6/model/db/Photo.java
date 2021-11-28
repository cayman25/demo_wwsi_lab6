package com.wwsi.lab6.model.db;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@Builder
public class Photo {

    @Id
    private String _id;
    private String name;
    private String description;
    private List<String> tags;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String url;
}
