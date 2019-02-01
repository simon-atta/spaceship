package com.spaceship.model.vo.shot;

public class SalvoShotResponse {

    private String bullet;
    private String result;

    public SalvoShotResponse() {
        super();
    }

    public SalvoShotResponse(String bullet, String result) {
        super();
        this.bullet = bullet;
        this.result = result;
    }

    /**
     * @return the bullet
     */
    public String getBullet() {
        return bullet;
    }

    /**
     * @param bullet
     *        the bullet to set
     */
    public void setBullet(String bullet) {
        this.bullet = bullet;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     *        the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

}
