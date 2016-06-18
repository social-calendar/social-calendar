import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';

class Test extends React.Component{
	constructor(props) {
        super(props);
    }
	render(){
		return(
			<div>
				<button>点击</button>
				
			</div>
		);
	}
}
ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <Test />
   </MuiThemeProvider>,
   document.getElementsByClassName('test')[0] 
);