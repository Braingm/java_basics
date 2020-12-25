import java.text.DecimalFormat;

public class Hospital {

    private static final int MIN_TEMPERATURE = 32;
    private static final int MAX_TEMPERATURE = 40;
    private static final float MIN_NORMAL_TEMPERATURE = 36.1f;
    private static final float MAX_NORMAL_TEMPERATURE = 37f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] result = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            result[i] = (float) ((Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE)) + MIN_TEMPERATURE);
        }
        return result;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder report = new StringBuilder();
        float temperatureSum = 0;
        int healthyPatients = 0;

        report.append("Температуры пациентов: ");
        for (float fl : temperatureData) {
            report.append(fl + " ");
            if (fl > MIN_NORMAL_TEMPERATURE && fl < MAX_NORMAL_TEMPERATURE) {
                healthyPatients++;
            }
            temperatureSum += fl;
        }
        report.deleteCharAt(report.length()-1);

        report.append("\nСредняя температура: ")
              .append(new DecimalFormat("#0.0").format(temperatureSum/temperatureData.length));

        report.append("\nКоличество здоровых: ")
              .append(healthyPatients);

        return report.toString();
    }
}
