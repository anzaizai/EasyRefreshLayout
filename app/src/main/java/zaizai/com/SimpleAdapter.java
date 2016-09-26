package zaizai.com;

import com.ajguan.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by guanaj on 16/9/3.
 */
public class SimpleAdapter extends BaseQuickAdapter<String> {
    public SimpleAdapter() {
        super(R.layout.items_recyclerview, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
