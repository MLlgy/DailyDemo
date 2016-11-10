package MutiThreadsDownloadFile.entities;

/**
 * Created by Monkey
 * on 2016/11/2.
 * 线程信息
 */

public class ThreadInfo {
    private int id;
    private String url;
    private long start;
    private long end;
    private long finished;

    public ThreadInfo() {
        super();
    }

    /**
     *
     * @param id 线程的id
     * @param url 线程信息的url
     * @param start 线程信息的开始位置
     * @param end 线程信息的结束位置
     * @param finished 该线程的下载进度
     */
    public ThreadInfo(int id, String url, long start, long end, long finished) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
