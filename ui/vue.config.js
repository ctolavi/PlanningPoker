module.exports = {
  lintOnSave: false,
  devServer: {
    port: 4100,
    proxy: 'http://localhost:8080/',
  }
};
