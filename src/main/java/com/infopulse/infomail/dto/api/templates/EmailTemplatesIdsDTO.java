package com.infopulse.infomail.dto.api.templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplatesIdsDTO {

	private List<Long> ids;

}