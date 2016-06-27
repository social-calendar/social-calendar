const webpack = require('webpack');
const path = require('path');
const buildPath = path.resolve(__dirname, 'app/WebRoot/build');
const nodeModulesPath = path.resolve(__dirname, 'node_modules');
const TransferWebpackPlugin = require('transfer-webpack-plugin');

const config = {
  entry: {
    // 'webpack/hot/dev-server',
    // 'webpack/hot/only-dev-server',
    home:path.join(__dirname, '/src/main/webapp/component/ActiveList.js'),
    add:path.join(__dirname, '/src/main/webapp/component/AddActive.js'),
    detail:path.join(__dirname, '/src/main/webapp/component/ActiveDetail.js'),
    edit:path.join(__dirname, '/src/main/webapp/component/ActiveEdit.js'),
    comment:path.join(__dirname, '/src/main/webapp/component/ActiveComment.js'),

    test:path.join(__dirname, '/src/main/webapp/component/Test.js'),
  },
  resolve: {
    //When require, do not have to add these extensions to file's name
    extensions: ["", ".js",".jsx"],
    //node_modules: ["web_modules", "node_modules"]  (Default Settings)
  },
  //Render source-map file for final build
  // devtool: 'source-map',
  //output config
  output: {
    path: buildPath,    //Path of output file
    filename: '[name].bundle.js',  //Name of output file
  },
  plugins: [
    //Minify the bundle
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        //supresses warnings, usually from module minification
        warnings: false,
      },
    }),
    new webpack.optimize.DedupePlugin(),
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.DefinePlugin({
        'process.env.NODE_ENV': JSON.stringify('production')
    }),

    //Allows error warnings but does not stop compiling. Will remove when eslint is added
    new webpack.NoErrorsPlugin(),
    //Transfer Files
    new TransferWebpackPlugin([
      {from: 'www'},
    ], path.resolve(__dirname,"src/main/webapp")),
  ],
  module: {
    loaders: [
      {
        test: /\.js$/, // All .js files
        loaders: ['babel-loader'], //react-hot is like browser sync and babel loads jsx and es6-7
        exclude: [nodeModulesPath],
      },
    ],
  },
  //Eslint config
  eslint: {
    configFile: '.eslintrc', //Rules for eslint
  },
};

module.exports = config;
