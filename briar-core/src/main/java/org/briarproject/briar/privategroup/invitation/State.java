package com.ksmessaging.privategroup.invitation;

import org.briarproject.bramble.api.sync.Group.Visibility;

interface State {

	int getValue();

	Visibility getVisibility();

	boolean isAwaitingResponse();
}
