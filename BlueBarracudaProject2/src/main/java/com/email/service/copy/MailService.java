package com.email.service.copy;

public interface MailService
{
	public void sendEmail(final String senderEmailId, final String receiverEmailId,
			final String subject, final String message);
}
