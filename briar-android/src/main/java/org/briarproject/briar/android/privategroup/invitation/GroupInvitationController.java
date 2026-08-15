package com.ksmessaging.android.privategroup.invitation;

import com.ksmessaging.android.sharing.InvitationController;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationItem;
import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
interface GroupInvitationController
		extends InvitationController<GroupInvitationItem> {
}
