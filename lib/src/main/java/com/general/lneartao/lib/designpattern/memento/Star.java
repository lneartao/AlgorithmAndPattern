package com.general.lneartao.lib.designpattern.memento;

/**
 * Created by lneartao on 2017/12/1.
 */

public class Star {
    private int ageYears;
    private int massTons;
    private StarType starType;

    public Star(int ageYears, int massTons, StarType starType) {
        this.ageYears = ageYears;
        this.massTons = massTons;
        this.starType = starType;
    }

    public void timePasses() {
        ageYears *= 2;
        massTons *= 8;
        switch (starType) {
            case RED_GIANT:
                starType = StarType.WHITE_DWARF;
                break;
            case SUN:
                starType = StarType.RED_GIANT;
                break;
            case SUPERNOVA:
                starType = StarType.DEAD;
                break;
            case WHITE_DWARF:
                starType = StarType.SUPERNOVA;
                break;
            case DEAD:
                ageYears *= 2;
                massTons = 0;
                break;
            default:
                break;
        }
    }

    public StarMemento getMemento() {
        return new StarMementoInternal(ageYears, massTons, starType);
    }

    public void setMemento(StarMemento starMemento) {
        StarMementoInternal state = (StarMementoInternal) starMemento;
        ageYears = state.getAgeYears();
        massTons = state.getMassTons();
        starType = state.getStarType();
    }

    @Override
    public String toString() {
        return starType + "age: " + ageYears + " years mass: " + massTons + " tons.";
    }

    private static class StarMementoInternal implements StarMemento {
        private int ageYears;
        private int massTons;
        private StarType starType;

        public StarMementoInternal(int ageYears, int massTons, StarType starType) {
            this.ageYears = ageYears;
            this.massTons = massTons;
            this.starType = starType;
        }

        public int getAgeYears() {
            return ageYears;
        }

        public void setAgeYears(int ageYears) {
            this.ageYears = ageYears;
        }

        public int getMassTons() {
            return massTons;
        }

        public void setMassTons(int massTons) {
            this.massTons = massTons;
        }

        public StarType getStarType() {
            return starType;
        }

        public void setStarType(StarType starType) {
            this.starType = starType;
        }
    }
}
