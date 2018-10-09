package com.general.lneartao.lib.refactor.rearrange;

/**
 * 分解临时变量：针对每次赋值，创造一个独立、对应的临时变量
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class SplitTemporaryVariable {
    int mPrimaryForce;
    int mMass;
    int mDelay;
    int mSecondaryForce;

    double getDistanceTravelledUgly(int time) {
        double result;
        double acc = mPrimaryForce / mMass;
        int primaryTime = Math.min(time, mDelay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - mDelay;
        if (secondaryTime > 0) {
            double primaryVel = acc * mDelay;
            acc = (mPrimaryForce + mSecondaryForce) / mMass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime + secondaryTime;
        }
        return result;
    }

    /**
     * TODO 还可以继续重构优化
     *
     * @param time
     *
     * @return
     */
    double getDistanceTravelled(int time) {
        double result;
        final double primaryAcc = mPrimaryForce / mMass;
        int primaryTime = Math.min(time, mDelay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - mDelay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * mDelay;
            final double secondaryAcc = (mPrimaryForce + mSecondaryForce) / mMass;
            result +=
                    primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime + secondaryTime;
        }
        return result;
    }
}
