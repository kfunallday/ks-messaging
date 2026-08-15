package com.ksmessaging.android.sharing;

import org.briarproject.bramble.api.db.DbException;
import com.ksmessaging.android.controller.ActivityLifecycleController;
import com.ksmessaging.android.controller.handler.ExceptionHandler;
import com.ksmessaging.android.controller.handler.ResultExceptionHandler;
import com.ksmessaging.api.sharing.InvitationItem;
import org.briarproject.nullsafety.NotNullByDefault;

import java.util.Collection;

@NotNullByDefault
public interface InvitationController<I extends InvitationItem>
		extends ActivityLifecycleController {

	void loadInvitations(boolean clear,
			ResultExceptionHandler<Collection<I>, DbException> handler);

	void respondToInvitation(I item, boolean accept,
			ExceptionHandler<DbException> handler);

	interface InvitationListener {

		void loadInvitations(boolean clear);

	}

}
