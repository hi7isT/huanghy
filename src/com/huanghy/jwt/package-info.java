/**
 * <pre>
 *     jwt,json web token.
 *     这个规范允许我们使用JWT在用户和服务器之间传递安全可靠的信息。
 *     JWT常被用于前后端分离，可以和Restful API配合使用，常用于构建身份认证机制
 *     
 *     JWT由三部分组成,它们之间使用”.”号分隔，
 *     JWT header中声明类型为JWT并采用RS256签名算法.
 *     JWT payload载荷中声明jti(jwt的唯一身份标识,实现使用UUID)、iss(签发者)、sub(面向的用户)、aud(接收的一方)、iat(签发时间，默认当前时间)、exp(过期时间)及用户身份信息.
 *     JWT signature 签证信息算法base64UrlEncode(header) + "." + base64UrlEncode(payload)+your-256-bit-secret.
 * </pre>
 *
 * @author huanghy <br>create on 2018/12/8
 */
package com.huanghy.jwt;