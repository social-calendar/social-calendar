//活动讨论组件

import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';

import Avatar from 'material-ui/Avatar';
import {List,ListItem} from 'material-ui/List';
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import IconButton from 'material-ui/IconButton';
import {tealA700} from 'material-ui/styles/colors';

//svg图标
import ContentSend from 'material-ui/svg-icons/content/send';


class ActiveComment extends React.Component{
	constructor(props){
		super(props);
	}

	handleClick () {
		alert('aaa');
	}

	render(){
		return(
			<div>
				<Paper zDepth={0}>
					<List>
						<ListItem
	                        leftAvatar={<Avatar src="images/1.jpg"/>}
	                        primaryText="小明"
	                        secondaryText="一起去啊，走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走"
	                        secondaryTextLines={2}
	                        rightIcon={<span style={{width:'auto'}}>2016-06-16 17:45</span>}                               
	                    />
	                    <Divider/>
	                    <ListItem
	                        leftAvatar={<Avatar src="images/1.jpg"/>}
	                        primaryText="小明"
	                        secondaryText="一起去啊，走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走走"
	                        secondaryTextLines={2}
	                        rightIcon={<span style={{width:'auto'}}>2016-06-16 17:45</span>}                               
	                    />
					</List>
				</Paper>
				<div style={{margin:'0 auto',marginTop:20,width:'90%',position:'relative'}}>	         
                	<TextField 
                		hintText="说点什么吧..."  
                		multiLine={true} 
                		style={{width:'85%'}}
                    />
                    <IconButton touch={true} style={{position:'absolute',bottom:0}}>
                       	<ContentSend  color={tealA700}/>	
                    </IconButton>
				</div>
			</div>
		)
	}
}

ReactDOM.render(
	<MuiThemeProvider muiTheme={MyTheme}>
		<ActiveComment/>
	</MuiThemeProvider>,
	document.getElementsByClassName('comment')[0]
);