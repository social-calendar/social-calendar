//活动详情
import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';

import Paper from 'material-ui/Paper';
import {List, ListItem} from 'material-ui/List';
import Avatar from 'material-ui/Avatar';
import {tealA700} from 'material-ui/styles/colors';
import Divider from 'material-ui/Divider';
import Subheader from 'material-ui/Subheader';
import {Card, CardActions, CardHeader, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';
import FlatButton from 'material-ui/FlatButton';
import FloatingActionButton from 'material-ui/FloatingActionButton';


//svg图标
import ActionAssignment from 'material-ui/svg-icons/action/assignment';
import DeviceAccessTime from 'material-ui/svg-icons/device/access-time';
import Place from 'material-ui/svg-icons/maps/place';
import Notifications from 'material-ui/svg-icons/social/notifications';
import Share from 'material-ui/svg-icons/social/share';
import ChevronRight from 'material-ui/svg-icons/navigation/chevron-right';
import Edit from 'material-ui/svg-icons/image/edit';
import Editor from 'material-ui/svg-icons/editor/border-color';







const paperStyle={
    marginBottom:20,
};

const avatarStyle={
	marginLeft:10
};

const shareStyle={
    width:'100%'
};

const editButton={
    position:'fixed',
    right:0,
    bottom:30,
}

class ActiveDetail extends React.Component{
	constructor(props) {
        super(props);
    }
    render(){
    	return(
    		<div>
    			<Paper zDepth={0} style={paperStyle}>
		    		<List>
		    			<ListItem
		    				leftAvatar={<Avatar src="/images/1.jpg" />}
		    				primaryText="小兰"
		        			secondaryText="创建了活动"
		    			/>
		    			<Divider/>
		    			<ListItem
		    				leftIcon={<ActionAssignment />}
		    				primaryText="去郊游"
		    			/>
		    			<ListItem 
		    				leftIcon={<DeviceAccessTime/>}
		    				primaryText="2016-06-16 15:30-16:30"
		    			/>
		    			<ListItem
		    				leftIcon={<Place/>}
		    				primaryText="千岛湖"
		    			/>
		    			<ListItem
		    				leftIcon={<Notifications/>}
		    				primaryText="提前10分钟提醒"
		    			/>	
		    			<Divider/>
		    			<ListItem primaryText="共3人参加了活动" style={{fontSize:'12px'}}/>		    			
		    			<Avatar src="images/1.jpg" style={avatarStyle}/>   						
		    			<Avatar src="images/1.jpg" style={avatarStyle}/>   						
		    			<Avatar src="images/1.jpg" style={avatarStyle}/><br/><br/>   						
    					<RaisedButton 
    						label="点击右上角分享给微信好友" 
    						primary={true}   
    						icon={<Share/>}
    						style={shareStyle}
    					/>
		    		</List>
    			</Paper>
    			
                <Paper zDepth={0} style={paperStyle}>
                    <List>
                            <ListItem 
                                primaryText="活动讨论(2条讨论)" 
                                href="comment.html?activeId=123"
                                rightIcon={<ChevronRight/>}
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

                <Paper zDepth={0} >
                    <Card>
                        <CardHeader
                            title="活动详情"
                        />
                        <Divider/>
                        <CardText>
                            你好好哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                            哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                        </CardText>
                    </Card>
                </Paper>
                <FloatingActionButton secondary={true} style={editButton} href="edit.html?activeId=123" linkButton={true}>
                    <Edit/>
                </FloatingActionButton>
    		</div>    		
    	)
    }
}



ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <ActiveDetail />
   </MuiThemeProvider>,
   document.getElementsByClassName('detail')[0] 
);
