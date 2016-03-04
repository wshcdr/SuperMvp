package com.ly.supermvp.model;

import com.ly.supermvp.server.RetrofitService;
import com.ly.supermvp.model.entity.NewsResponse;
import com.orhanobut.logger.Logger;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * <Pre>
 *     新闻数据实现类
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p/>
 *          Create by 2016/1/28 14:54
 */
public class NewsModelImpl implements NewsModel{
    public static final String CHANNEL_ID = "5572a109b3cdc86cf39001db";//频道id 来自api指定
    public static final String CHANNEL_NAME = "国内最新";//频道名称 来自api指定
    @Override
    public void netLoadNewsList(int page, String channelId, String channelName, final OnNetListener listListener) {
        //此处采用Retrofit的官方响应方式，天气预报采用RxJava
        Call<NewsResponse> call = RetrofitService.getInstance()
                .createNewsApi()
                .getNewsList(page, CHANNEL_ID, CHANNEL_NAME);

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Response<NewsResponse> response, Retrofit retrofit) {
                Logger.d(response.message() + response.code() + response.body().showapi_res_code
                        + response.body().showapi_res_error);
                listListener.onSuccess(response.body().showapi_res_body.pagebean.contentlist);
            }

            @Override
            public void onFailure(Throwable t) {
                listListener.onFailure(t);
            }
        });
    }
}
