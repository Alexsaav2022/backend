/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.demo.auth;

/**
 *
 * @author ACER
 */
public class JwtConfig {

    public static final String LLAVE_SECRETA = "miclave987654321";
    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n"
            + "MIIEowIBAAKCAQEAzMU/NXfxz3f8MzXIhvh1TI59Sr/CgOhzAHXz/hQs//BV3m6X\n"
            + "PRwlj/hi+lRcfqldyYxgPRIaRosWTWPPOdcGSD5gxvKV5jRMeqqwrhNy+fRymkLo\n"
            + "9YL3I2K4KZl5oCF87nv30jmMyDL3ZeejWh2qp5JuQOzDrwXrpKW88C9GC5mYcq47\n"
            + "JvrvYIw5PlL8Ij245NQO0VDU4B5b7ZRgzDM5FgWjtLjdyZwzBchT8E4SwH1GPgn0\n"
            + "f4QTDBvFICAlQCS8dXLFnUE2RbhWJW3sEfoe/Ek9PVeVso8LeIhhVPe1Gv9nDyFp\n"
            + "II+JRaQ44l2Cf7wqLp4c3bBFfyWp+D41x3h7YQIDAQABAoIBABz1N/8juzqPyUak\n"
            + "sHsF3/C3pdhQTf1U4g6Kn7qqt8JqBnqyQQkPVfCKO9US4RG4ed7qzyFT0gtv1/OR\n"
            + "zdhsJCNLTvxTigdIFhiy0tGLRpM6kopmM/OkVbbXWxvm7GBM3BINzfoY0WPucTYk\n"
            + "D+HKmDuiZZ0g3nt95tkd5x5AUTOKgFZfKT4hTb06br1t0FJgRqsKjV5221K//ucd\n"
            + "j/UhvOjKQi5Cy/LvpM0qJ/n4WnZyeLul0S4JLpKCaiDIxxcyMxE7KtemXbZ1qrdJ\n"
            + "8BDoffu9zmkrxr2EBes39Kceyt35ziR2eoVGew/1DNaklXuWJoQYu3ixAlcUDq6y\n"
            + "+ReoahECgYEA5l2HK7/hPiw3NdnbbCBSobJcZArw4pbUuky25Ga9l+OWg3iIHZ2F\n"
            + "L1jAzKB+MNN8RWC1Ys1b10IAQIiVBaKzDJM7hiH2PRmCrfFGZBCIQpUrBBbhf9pU\n"
            + "6x1l3mnw2AOIewYaD9lbYwlfEX7nY/ZFLikvH0GzfDc5Y2ByT72yCEsCgYEA446X\n"
            + "qGR9In6vgOkJd+p6eYzQC8FJP0B3qLlhbxA6BTqiFtROFFDkv+yy+VTip0o6z6OV\n"
            + "2DDuisv1Yc96/ulQQdqHyp5IudcmtW+UKJN+fLbJFpiI3uWFDXvJkoW5k+117KKz\n"
            + "L2j8O7aTsEqP+E2zeUCQs4sRzkAfYgc7m38ul4MCgYAFAkmbIOvz3yBAMoF742QI\n"
            + "kglCP56nPqJXfq2HX9iFgfRW3XsQMcmgkux2RpMX2rFcDNNE17REhPHedVnQKo58\n"
            + "GoNz0i85euGFiLaAHH/p+rZZu2mhzwyDpDr/0AvlloYULrjIWXCMQbrodXrwiH1O\n"
            + "mKSmqFYPwF+mEoXJyBUj6wKBgBoqm2XRqFH/H09DfMM9QzgW6RVw9GtBjoDoUDvl\n"
            + "McbIJztYzmGnq6YmIa5qBGYYMwsNVH23orZzHZRRt2L4kTIBXvv9l39HLjxOyEqi\n"
            + "KzlMC3N9tr9qxRH32gXvOpe4BodfbhtVhyuWowTyjfuPc8PNmNYMd8+vr+wlyMTo\n"
            + "qwLhAoGBAL1kysDyLMHGZyHCsZ9nepJNVwd5gWpVoTxDvHJVG1aB66ISzNAMJBPt\n"
            + "DH2k4esVCqdAPQBl2RPUOV47g95rK7thNIx5tDBsnl7MTrhpp2qn4hW3cNzlu0gy\n"
            + "QR+boJj+DJysYx3ZWXuNPNmet+VIVWt3rotwz/0/CTMmIi5/+yAy\n"
            + "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
            + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzMU/NXfxz3f8MzXIhvh1\n"
            + "TI59Sr/CgOhzAHXz/hQs//BV3m6XPRwlj/hi+lRcfqldyYxgPRIaRosWTWPPOdcG\n"
            + "SD5gxvKV5jRMeqqwrhNy+fRymkLo9YL3I2K4KZl5oCF87nv30jmMyDL3ZeejWh2q\n"
            + "p5JuQOzDrwXrpKW88C9GC5mYcq47JvrvYIw5PlL8Ij245NQO0VDU4B5b7ZRgzDM5\n"
            + "FgWjtLjdyZwzBchT8E4SwH1GPgn0f4QTDBvFICAlQCS8dXLFnUE2RbhWJW3sEfoe\n"
            + "/Ek9PVeVso8LeIhhVPe1Gv9nDyFpII+JRaQ44l2Cf7wqLp4c3bBFfyWp+D41x3h7\n"
            + "YQIDAQAB\n"
            + "-----END PUBLIC KEY-----";
}