package MutiThreadsDownloadFile.db;

import java.util.List;

import MutiThreadsDownloadFile.entities.ThreadInfo;

/**
 * Created by Monkey
 * on 2016/11/3.
 * 数据访问接口
 */

public interface ThreadDao {
    /**
     * 插入线程信息
     * @param threadInfo
     */
    public void insertThread(ThreadInfo threadInfo);
    /**
     * 删除线程信息
     */
    public void deleteThread(String url);
    /**
     * 更新线程下载进度
     */
    public void updataThread(String url, int thread_id, long finished);

    /**
     * 查询文件线程信息
     * @param url
     * @return
     */
    public List<ThreadInfo> getThread(String url);

    /**
     * 查询线程是否存在
     * @param url
     * @param thread_id
     * @return
     */
    public boolean isExists(String url, int thread_id);
}
