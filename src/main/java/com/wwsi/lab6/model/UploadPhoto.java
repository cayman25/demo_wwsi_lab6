package com.wwsi.lab6.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UploadPhoto {

private String description;
private String tags;

}
