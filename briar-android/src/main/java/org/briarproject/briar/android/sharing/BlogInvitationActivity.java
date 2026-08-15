package com.ksmessaging.android.sharing;

import android.content.Context;

import com.ksmessaging.R;
import com.ksmessaging.android.activity.ActivityComponent;
import com.ksmessaging.api.sharing.SharingInvitationItem;
import org.briarproject.nullsafety.MethodsNotNullByDefault;
import org.briarproject.nullsafety.ParametersNotNullByDefault;

import javax.inject.Inject;

import static com.ksmessaging.android.sharing.InvitationAdapter.InvitationClickListener;

@MethodsNotNullByDefault
@ParametersNotNullByDefault
public class BlogInvitationActivity
		extends InvitationActivity<SharingInvitationItem> {

	@Inject
	BlogInvitationController controller;

	@Override
	public void injectActivity(ActivityComponent component) {
		component.inject(this);
	}

	@Override
	protected InvitationController<SharingInvitationItem> getController() {
		return controller;
	}

	@Override
	protected InvitationAdapter<SharingInvitationItem, ?> getAdapter(
			Context ctx,
			InvitationClickListener<SharingInvitationItem> listener) {
		return new SharingInvitationAdapter(ctx, listener);
	}

	@Override
	protected int getAcceptRes() {
		return R.string.blogs_sharing_joined_toast;
	}

	@Override
	protected int getDeclineRes() {
		return R.string.blogs_sharing_declined_toast;
	}

}
