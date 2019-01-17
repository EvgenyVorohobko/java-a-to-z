package by.vorokhobko.fit;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(int height) {
        return (height-100)*1.15;
    }
    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(int height) {
        return (height-110)*1.15;
    }
}