<template>
  <div class="err-container">
    <p class="error-code">
      Error
    </p>
    <p class="not-found">发生<br />错误了呀!!!</p>
    <div class="clear"></div>
    <br>
    <br>
    <div class="content">
      please go home

      <br>
      <br /><a href="javascript:history.back(-1);">Go Home</a>
    </div>
  </div>
</template>
<style scoped>
  @font-face {
    font-family: 'Audiowide';
    font-style: normal;
    font-weight: 400;
    src: local('Audiowide Regular'), local('Audiowide-Regular'), url(https://fonts.gstatic.com/s/audiowide/v7/l7gdbjpo0cum0ckerWCdmA_OIxo.woff2) format('woff2');
    unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
  }

  @font-face {
    font-family: 'Audiowide';
    font-style: normal;
    font-weight: 400;
    src: local('Audiowide Regular'), local('Audiowide-Regular'), url(https://fonts.gstatic.com/s/audiowide/v7/l7gdbjpo0cum0ckerWCdlg_O.woff2) format('woff2');
    unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
  }

  @font-face {
    font-family: 'Creepster';
    font-style: normal;
    font-weight: 400;
    src: local('Creepster'), local('Creepster-Regular'), url(https://fonts.gstatic.com/s/creepster/v7/AlZy_zVUqJz4yMrniH4Rcn35.woff2) format('woff2');
    unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
  }

  * {
    margin: 0;
    padding: 0;
  }

  .err-container {
    height: 100vh;
    font-family: 'Audiowide', cursive, arial, helvetica, sans-serif;
    background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAUElEQVQYV2NkYGAwBuKzQAwDID4IoIgxIikAMZE1oRiArBDdZBSNMIXoJiFbDZYDKcSmCOYimDuNSVKIzRNYrUYOFuQgweoZbIoxgoeoAAcAEckW11HVTfcAAAAASUVORK5CYII=) repeat;
    background-color: #212121;
    color: white;
    font-size: 18px;
    padding-bottom: 20px;
  }

  .error-code {
    font-family: 'Creepster', cursive, arial, helvetica, sans-serif;
    font-size: 200px;
    color: white;
    color: rgba(255, 255, 255, 0.98);
    width: 50%;
    text-align: right;
    margin-top: 5%;
    text-shadow: 5px 5px hsl(0, 0%, 25%);
    float: left;
  }

  .not-found {
    width: 47%;
    float: right;
    margin-top: 5%;
    font-size: 50px;
    color: white;
    text-shadow: 2px 2px 5px hsl(0, 0%, 61%);
    padding-top: 70px;
  }

  .clear {
    float: none;
    clear: both;
  }

  .content {
    text-align: center;
    line-height: 30px;
  }

  input[type=text] {
    border: hsl(247, 89%, 72%) solid 1px;
    outline: none;
    padding: 5px 3px;
    font-size: 16px;
    border-radius: 8px;
  }

  a {
    text-decoration: none;
    color: #9ECDFF;
    text-shadow: 0px 0px 2px white;
  }

  a:hover {
    color: white;
  }
</style>