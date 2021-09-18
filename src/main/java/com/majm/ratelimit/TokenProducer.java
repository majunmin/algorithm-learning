package com.majm.ratelimit;

class TokenProducer implements Runnable {
    protected TokenBucket tokenBucket;

    public TokenProducer(TokenBucket tokenBucket) {
        this.tokenBucket = tokenBucket;
    }

    /**
     * 向令牌桶中添加令牌
     */
    @Override
    public void run() {
        tokenBucket.addToken();
    }
}