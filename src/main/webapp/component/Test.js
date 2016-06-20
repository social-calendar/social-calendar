import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';

class Test extends React.Component{
	constructor(props) {
        super(props);
        this.handleClick=this.handleClick.bind(this);
    }
    handleClick(){
    	console.log(this.refs.test.innerHTML);
    }
	render(){
		return(
			<div>
				<button onClick={this.handleClick}>点击</button>
				<div>
					<p ref="test" style={{display:'none'}}>你好</p>
				</div>
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