package ai.nova.nex.server.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String dayOfMonthStart() {
        // 本月起始
        Calendar thisMonthFirstDateCal = Calendar.getInstance();
        // 获取上月
        // thisMonthFirstDateCal.add(Calendar.MONTH, -1);
        thisMonthFirstDateCal.set(Calendar.DAY_OF_MONTH, thisMonthFirstDateCal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return format.format(thisMonthFirstDateCal.getTime()) + " 00:00:00";
    }

    public static String dayOfMonthEnd() {
        Calendar thisMonthEndDateCal = Calendar.getInstance();
        // 获取上月
        // thisMonthEndDateCal.add(Calendar.MONTH, -1);
        thisMonthEndDateCal.set(Calendar.DAY_OF_MONTH, thisMonthEndDateCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(thisMonthEndDateCal.getTime()) + " 23:59:59";
    }

    /**
     * 计算时间差并返回秒数，精确到小数点后三位
     *
     * @param startTime 开始时间（毫秒）
     * @param endTime   结束时间（毫秒）
     * @return 时间差（秒），精确到小数点后三位
     */
    public static Double deltaTime(long startTime, long endTime) {
        double deltaTime = (endTime - startTime) / 1000.0; // 毫秒转秒
        DecimalFormat decimalFormat = new DecimalFormat("0.###"); // 保留 3 位小数
        String formattedTime = decimalFormat.format(deltaTime); // 格式化为字符串
        return Double.parseDouble(formattedTime); // 转换为 Double
    }
}
