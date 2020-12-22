import java.text.DecimalFormat;

public class Hospital {

    private static final int minTemperature = 32;
    private static final int maxTemperature = 40;
    private static final float minNormalTemperature = 36.1f;
    private static final float maxNormalTemperature = 37f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] result = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            result[i] = (float) ((Math.random() * (maxTemperature - minTemperature)) + minTemperature);
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
            if (fl > minNormalTemperature && fl < maxNormalTemperature ) {
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
