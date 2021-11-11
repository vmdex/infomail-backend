package com.infopulse.infomail.dto.mail;

import com.infopulse.infomail.models.mail.Recipient;
import com.infopulse.infomail.models.mail.enums.RecipientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
public class RecipientDTO implements Recipient {

	@Email
	private String email;

	@NotBlank
	private RecipientType recipientType;

	public RecipientDTO() {
	}
}