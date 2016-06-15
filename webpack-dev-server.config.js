const webpack = require('webpack');
const path = require('path');
const buildPath = path.resolve(__dirname, 'build');
const nodeModulesPath = path.resolve(__dirname, 'node_modules');
const TransferWebpackPlugin = require('transfer-webpack-plugin');

const config = {
  //Entry points to the project
  entry: {
    // 'webpack/hot/dev-server',
    // 'webpack/hot/only-dev-server',
    home:path.join(__dirname, '/src/main/webapp/component/ActiveList.js'),
    add:path.join(__dirname, '/src/main/webapp/component/AddActive.js'),
    detail:path.join(__dirname, '/src/main/webapp/component/ActiveDetail.js'),

    // test:path.join(__dirname, '/src/main/webapp/component/DateTime.js'),

  },
  //Config options on how to interpret requires imports
  resolve: {
    extensions: ["", ".js",".jsx"],
    //node_modules: ["web_modules", "node_modules"]  (Default Settings)
  },
  //Server Configuration options
  devServer:{
    contentBase: 'src/main/webapp/www',  //Relative directory for base of server
    devtool: 'eval',//为你的代码创建源地址。当有任何报错的时候可以让你更加精确地定位到文件和行号
    hot: true,        //Live-reload
    inline: true,
    port: 1234,        //Port Number
    host: '0.0.0.0',  //Change to '0.0.0.0' for external facing server
    'process.env.NODE_ENV': 'dev'
  },
  devtool: 'eval',
  output: {
    path: buildPath,    //Path of output file
    filename: '[name].bundle.js',
  },
  plugins: [
    //Enables Hot Modules Replacement
    new webpack.HotModuleReplacementPlugin(),
    //Allows error warnings but does not stop compiling. Will remove when eslint is added
    new webpack.NoErrorsPlugin(),
    //Moves files
    new TransferWebpackPlugin([
      {from: 'www'},
    ], path.resolve(__dirname, "src/main/webapp")),
  ],
  module: {
    loaders: [
      {
        //React-hot loader and
        test: /\.js?$/,  //All .js files
        loaders: ['react-hot', 'babel-loader'], //react-hot is like browser sync and babel loads jsx and es6-7
        exclude: [nodeModulesPath],
      },
      //{ test: /\.css$/, loader: ['react-hot','style-loader!css-loader'],exclude: [nodeModulesPath],}
    ],
  },
  //eslint config options. Part of the eslint-loader package
  eslint: {
    configFile: '.eslintrc',
  },
};

module.exports = config;
