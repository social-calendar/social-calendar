//活动讨论组件

import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';
import Formate from './Formate.js';

import Avatar from 'material-ui/Avatar';
import {List,ListItem} from 'material-ui/List';
import Paper from 'material-ui/Paper';
import Divider from 'material-ui/Divider';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import IconButton from 'material-ui/IconButton';
import {tealA700} from 'material-ui/styles/colors';
import Snackbar from 'material-ui/Snackbar';

injectTapEventPlugin();

//svg图标
import ContentSend from 'material-ui/svg-icons/content/send';


class ActiveComment extends React.Component{
	constructor(props){
		super(props);
		this.handleTouchTap=this.handleTouchTap.bind(this);
        this.handleRequestClose=this.handleRequestClose.bind(this);
		this.state={
			open:false,
			data:[]
		}
	}

	componentDidMount(){
        $.get("../java/getComment.do",function (result) {
            this.setState({data:result.commentList});
        }.bind(this));
	}
	handleTouchTap () {
		var _this=this;
		$.ajax({
			type:"POST",
			url:'../java/saveComment.do',
			contentType:"application/json; charset=utf-8",
			data:{
				conent:_this.refs.content.getValue(),
				time:Formate.formate(new Date()),
			},
			success:function (result) {
				if (result.status===1) {
					//刷新当前页面
                    location.reload();
	            }else{
	                 _this.setState({
	                        open:true
                    });
                }
			}
		});
	}
	handleRequestClose(event){
        this.setState({
            open:false
        });
    }

	render(){
		return(
			<div>
				<Paper zDepth={0}>
					<List>
						{
							this.state.data.map(function (comment,index) {
							 	return(
							 		<div key={index}>
							 			<ListItem
                                            leftAvatar={<Avatar src={comment.userAvatar}/>}
                                            primaryText={comment.userName}
                                            secondaryText={comment.content}
                                            secondaryTextLines={2}
                                            rightIcon={<span style={{width:'auto'}}>{comment.time}</span>}                               
                                        />
					                    <Divider/>
							 		</div>
							 	)
							})
						}	              
					</List>
				</Paper>
				<div style={{margin:'0 auto',marginTop:20,width:'90%',position:'relative'}}>	         
                	<TextField 
                		hintText="说点什么吧..."  
                		multiLine={true} 
                		ref="content"
                		style={{width:'85%'}}
                    />
                    <IconButton touch={true} style={{position:'absolute',bottom:0}} onTouchTap={this.handleTouchTap}>
                       	<ContentSend  color={tealA700}/>	
                    </IconButton>
				</div>
				<Snackbar
	              open={this.state.open}
	              message="发生错误，请重试!"
	              autoHideDuration={2500}
	              onRequestClose={this.handleRequestClose}
	            />
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