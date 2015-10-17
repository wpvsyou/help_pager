package com.wp.demo;

/**
 * Created by Administrator on 2015/10/17.
 */
public class HelpPagerDetail {
    int backgroundResId;

    NextButtonPoint nextButtonTopLifePoint;
    NextButtonPoint nextButtonTopRightPoint;
    NextButtonPoint nextButtonBottomRightPoint;
    NextButtonPoint nextButtonBottomLifePoint;

    static class NextButtonPoint {
        double pointX; // Pixel scale.
        double pointY; // Pixel scale.

        @Override
        public String toString() {
            return "NextButtonPoint{" +
                    "pointX=" + pointX +
                    ", pointY=" + pointY +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelpPagerDetail that = (HelpPagerDetail) o;

        if (backgroundResId != that.backgroundResId) return false;
        if (nextButtonTopLifePoint != null ? !nextButtonTopLifePoint.equals(that.nextButtonTopLifePoint) : that.nextButtonTopLifePoint != null)
            return false;
        if (nextButtonTopRightPoint != null ? !nextButtonTopRightPoint.equals(that.nextButtonTopRightPoint) : that.nextButtonTopRightPoint != null)
            return false;
        if (nextButtonBottomRightPoint != null ? !nextButtonBottomRightPoint.equals(that.nextButtonBottomRightPoint) : that.nextButtonBottomRightPoint != null)
            return false;
        return !(nextButtonBottomLifePoint != null ? !nextButtonBottomLifePoint.equals(that.nextButtonBottomLifePoint) : that.nextButtonBottomLifePoint != null);

    }

    @Override
    public int hashCode() {
        int result = backgroundResId;
        result = 31 * result + (nextButtonTopLifePoint != null ? nextButtonTopLifePoint.hashCode() : 0);
        result = 31 * result + (nextButtonTopRightPoint != null ? nextButtonTopRightPoint.hashCode() : 0);
        result = 31 * result + (nextButtonBottomRightPoint != null ? nextButtonBottomRightPoint.hashCode() : 0);
        result = 31 * result + (nextButtonBottomLifePoint != null ? nextButtonBottomLifePoint.hashCode() : 0);
        return result;
    }

    public int getBackgroundResId() {
        return backgroundResId;
    }

    public void setBackgroundResId(int backgroundResId) {
        this.backgroundResId = backgroundResId;
    }

    public NextButtonPoint getNextButtonTopLifePoint() {
        return nextButtonTopLifePoint;
    }

    public void setNextButtonTopLifePoint(NextButtonPoint nextButtonTopLifePoint) {
        this.nextButtonTopLifePoint = nextButtonTopLifePoint;
    }

    public NextButtonPoint getNextButtonTopRightPoint() {
        return nextButtonTopRightPoint;
    }

    public void setNextButtonTopRightPoint(NextButtonPoint nextButtonTopRightPoint) {
        this.nextButtonTopRightPoint = nextButtonTopRightPoint;
    }

    public NextButtonPoint getNextButtonBottomRightPoint() {
        return nextButtonBottomRightPoint;
    }

    public void setNextButtonBottomRightPoint(NextButtonPoint nextButtonBottomRightPoint) {
        this.nextButtonBottomRightPoint = nextButtonBottomRightPoint;
    }

    public NextButtonPoint getNextButtonBottomLifePoint() {
        return nextButtonBottomLifePoint;
    }

    public void setNextButtonBottomLifePoint(NextButtonPoint nextButtonBottomLifePoint) {
        this.nextButtonBottomLifePoint = nextButtonBottomLifePoint;
    }

    @Override
    public String toString() {
        return "HelpPagerDetail{" +
                "backgroundResId=" + backgroundResId +
                ", nextButtonTopLifePoint=" + nextButtonTopLifePoint +
                ", nextButtonTopRightPoint=" + nextButtonTopRightPoint +
                ", nextButtonBottomRightPoint=" + nextButtonBottomRightPoint +
                ", nextButtonBottomLifePoint=" + nextButtonBottomLifePoint +
                '}';
    }
}
