import React from 'react';
import ReactDOM from 'react-dom';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';
import ActiveList from './component/ActiveList';
import AddActive from './component/AddActive';

injectTapEventPlugin();

ReactDOM.render(
   <MuiThemeProvider muiTheme={getMuiTheme()}>
    <ActiveList />
   </MuiThemeProvider>,
   document.getElementsByClassName('home')[0] 
);

ReactDOM.render(
   <MuiThemeProvider muiTheme={getMuiTheme()}>
    <AddActive />
   </MuiThemeProvider>,
   document.getElementsByClassName('add')[0] 
);
