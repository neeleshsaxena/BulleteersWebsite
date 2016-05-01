package com.bulleteers.club;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bulleteers.club.dao.MemberDao;
import com.bulleteers.club.dao.MessageDao;
import com.bulleteers.club.dao.RideDao;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;
import com.bulleteers.club.pojo.Ride;
import com.bulleteers.club.pojo.UserAccount;

@Controller
public class DumpController {
	
	
	@Autowired
	RideDao rideDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MessageDao messageDao;
	
	
	//ajax call to populate cities
		@RequestMapping(value="/cities", method = RequestMethod.GET)
		public @ResponseBody String sendclub(@RequestParam("city") String city){
			
			try{
				String [] cities = new String[351];
				
			cities[0] = "Abington";
			cities[1] = "Acton";
			cities[2] = "Acushnet";
			cities[3] = "Adams";
			cities[4] = "Agawam";
			cities[5] = "Alford";
			cities[6] = "Amesbury";
			cities[7] = "Amherst";
			cities[8] = "Andover";
			cities[9] = "Aquinnah";
			cities[10] = "Arlington";
			cities[11] = "Ashburnham";
			cities[12] = "Ashby";
			cities[13] = "Ashfield";
			cities[14] = "Ashland";
			cities[15] = "Athol";
			cities[16] = "Attleboro";
			cities[17] = "Auburn";
			cities[18] = "Avon";
			cities[19] = "Ayer";
			cities[20] = "Barnstable";
			cities[21] = "Barre";
			cities[22] = "Becket";
			cities[23] = "Bedford";
			cities[24] = "Belchertown";
			cities[25] = "Bellingham";
			cities[26] = "Belmont";
			cities[27] = "Berkley";
			cities[28] = "Berlin";
			cities[29] = "Bernardston";
			cities[30] = "Beverly";
			cities[31] = "Billerica";
			cities[32] = "Blackstone";
			cities[33] = "Blandford";
			cities[34] = "Bolton";
			cities[35] = "Boston";
			cities[36] = "Bourne";
			cities[37] = "Boxborough";
			cities[38] = "Boxford";
			cities[39] = "Boylston";
			cities[40] = "Braintree";
			cities[41] = "Brewster";
			cities[42] = "Bridgewater";
			cities[43] = "Brimfield";
			cities[44] = "Brockton";
			cities[45] = "Brookfield";
			cities[46] = "Brookline";
			cities[47] = "Buckland";
			cities[48] = "Burlington";
			cities[49] = "Cambridge";
			cities[50] = "Canton";
			cities[51] = "Carlisle";
			cities[52] = "Carver";
			cities[53] = "Charlemont";
			cities[54] = "Charlton";
			cities[55] = "Chatham";
			cities[56] = "Chelmsford";
			cities[57] = "Chelsea";
			cities[58] = "Cheshire";
			cities[59] = "Chester";
			cities[60] = "Chesterfield";
			cities[61] = "Chicopee";
			cities[62] = "Chilmark";
			cities[63] = "Clarksburg";
			cities[64] = "Clinton";
			cities[65] = "Cohasset";
			cities[66] = "Colrain";
			cities[67] = "Concord";
			cities[68] = "Conway";
			cities[69] = "Cummington";
			cities[70] = "Dalton";
			cities[71] = "Danvers";
			cities[72] = "Dartmouth";
			cities[73] = "Dedham";
			cities[74] = "Deerfield";
			cities[75] = "Dennis";
			cities[76] = "Dighton";
			cities[77] = "Douglas";
			cities[78] = "Dover";
			cities[79] = "Dracut";
			cities[80] = "Dudley";
			cities[81] = "Dunstable";
			cities[82] = "Duxbury";
			cities[83] = "East Bridgewater";
			cities[84] = "East Brookfield";
			cities[85] = "East Longmeadow";
			cities[86] = "Eastham";
			cities[87] = "Easthampton";
			cities[88] = "Easton";
			cities[89] = "Edgartown";
			cities[90] = "Egremont";
			cities[91] = "Erving";
			cities[92] = "Essex";
			cities[93] = "Everett";
			cities[94] = "Fairhaven";
			cities[95] = "Fall River";
			cities[96] = "Falmouth";
			cities[97] = "Fitchburg";
			cities[98] = "Florida";
			cities[99] = "Foxborough";
			cities[100] = "Framingham";
			cities[101] = "Franklin";
			cities[102] = "Freetown";
			cities[103] = "Gardner";
			cities[104] = "Georgetown";
			cities[105] = "Gill";
			cities[106] = "Gloucester";
			cities[107] = "Goshen";
			cities[108] = "Gosnold";
			cities[109] = "Grafton";
			cities[110] = "Granby";
			cities[111] = "Granville";
			cities[112] = "Great Barrington";
			cities[113] = "Greenfield";
			cities[114] = "Groton";
			cities[115] = "Groveland";
			cities[116] = "Hadley";
			cities[117] = "Halifax";
			cities[118] = "Hamilton";
			cities[119] = "Hampden";
			cities[120] = "Hancock";
			cities[121] = "Hanover";
			cities[122] = "Hanson";
			cities[123] = "Hardwick";
			cities[124] = "Harvard";
			cities[125] = "Harwich";
			cities[126] = "Hatfield";
			cities[127] = "Haverhill";
			cities[128] = "Hawley";
			cities[129] = "Heath";
			cities[130] = "Hingham";
			cities[131] = "Hinsdale";
			cities[132] = "Holbrook";
			cities[133] = "Holden";
			cities[134] = "Holland";
			cities[135] = "Holliston";
			cities[136] = "Holyoke";
			cities[137] = "Hopedale";
			cities[138] = "Hopkinton";
			cities[139] = "Hubbardston";
			cities[140] = "Hudson";
			cities[141] = "Hull";
			cities[142] = "Huntington";
			cities[143] = "Ipswich";
			cities[144] = "Kingston";
			cities[145] = "Lakeville";
			cities[146] = "Lancaster";
			cities[147] = "Lanesborough";
			cities[148] = "Lawrence";
			cities[149] = "Lee";
			cities[150] = "Leicester";
			cities[151] = "Lenox";
			cities[152] = "Leominster";
			cities[153] = "Leverett";
			cities[154] = "Lexington";
			cities[155] = "Leyden";
			cities[156] = "Lincoln";
			cities[157] = "Littleton";
			cities[158] = "Longmeadow";
			cities[159] = "Lowell";
			cities[160] = "Ludlow";
			cities[161] = "Lunenburg";
			cities[162] = "Lynn";
			cities[163] = "Lynnfield";
			cities[164] = "Malden";
			cities[165] = "Manchester-by-the-Sea";
			cities[166] = "Mansfield";
			cities[167] = "Marblehead";
			cities[168] = "Marion";
			cities[169] = "Marlborough";
			cities[170] = "Marshfield";
			cities[171] = "Mashpee";
			cities[172] = "Mattapoisett";
			cities[173] = "Maynard";
			cities[174] = "Medfield";
			cities[175] = "Medford";
			cities[176] = "Medway";
			cities[177] = "Melrose";
			cities[178] = "Mendon";
			cities[179] = "Merrimac";
			cities[180] = "Methuen";
			cities[181] = "Middleborough";
			cities[182] = "Middlefield";
			cities[183] = "Middleton";
			cities[184] = "Milford";
			cities[185] = "Millbury";
			cities[186] = "Millis";
			cities[187] = "Millville";
			cities[188] = "Milton";
			cities[189] = "Monroe";
			cities[190] = "Monson";
			cities[191] = "Montague";
			cities[192] = "Monterey";
			cities[193] = "Montgomery";
			cities[194] = "Mount Washington";
			cities[195] = "Nahant";
			cities[196] = "Nantucket";
			cities[197] = "Natick";
			cities[198] = "Needham";
			cities[199] = "New Ashford";
			cities[200] = "New Bedford";
			cities[201] = "New Braintree";
			cities[202] = "New Marlborough";
			cities[203] = "New Salem";
			cities[204] = "Newbury";
			cities[205] = "Newburyport";
			cities[206] = "Newton";
			cities[207] = "Norfolk";
			cities[208] = "North Adams";
			cities[209] = "North Andover";
			cities[210] = "North Attleborough";
			cities[211] = "North Brookfield";
			cities[212] = "North Reading";
			cities[213] = "Northampton";
			cities[214] = "Northborough";
			cities[215] = "Northbridge";
			cities[216] = "Northfield";
			cities[217] = "Norton";
			cities[218] = "Norwell";
			cities[219] = "Norwood";
			cities[220] = "Oak Bluffs";
			cities[221] = "Oakham";
			cities[222] = "Orange";
			cities[223] = "Orleans";
			cities[224] = "Otis";
			cities[225] = "Oxford";
			cities[226] = "Palmer";
			cities[227] = "Paxton";
			cities[228] = "Peabody";
			cities[229] = "Pelham";
			cities[230] = "Pembroke";
			cities[231] = "Pepperell";
			cities[232] = "Peru";
			cities[233] = "Petersham";
			cities[234] = "Phillipston";
			cities[235] = "Pittsfield";
			cities[236] = "Plainfield";
			cities[237] = "Plainville";
			cities[238] = "Plymouth";
			cities[239] = "Plympton";
			cities[240] = "Princeton";
			cities[241] = "Provincetown";
			cities[242] = "Quincy";
			cities[243] = "Randolph";
			cities[244] = "Raynham";
			cities[245] = "Reading";
			cities[246] = "Rehoboth";
			cities[247] = "Revere";
			cities[248] = "Richmond";
			cities[249] = "Rochester";
			cities[250] = "Rockland";
			cities[251] = "Rockport";
			cities[252] = "Rowe";
			cities[253] = "Rowley";
			cities[254] = "Royalston";
			cities[255] = "Russell";
			cities[256] = "Rutland";
			cities[257] = "Salem";
			cities[258] = "Salisbury";
			cities[259] = "Sandisfield";
			cities[260] = "Sandwich";
			cities[261] = "Saugus";
			cities[262] = "Savoy";
			cities[263] = "Scituate";
			cities[264] = "Seekonk";
			cities[265] = "Sharon";
			cities[266] = "Sheffield";
			cities[267] = "Shelburne";
			cities[268] = "Sherborn";
			cities[269] = "Shirley";
			cities[270] = "Shrewsbury";
			cities[271] = "Shutesbury";
			cities[272] = "Somerset";
			cities[273] = "Somerville";
			cities[274] = "South Hadley";
			cities[275] = "Southampton";
			cities[276] = "Southborough";
			cities[277] = "Southbridge";
			cities[278] = "Southwick";
			cities[279] = "Spencer";
			cities[280] = "Springfield";
			cities[281] = "Sterling";
			cities[282] = "Stockbridge";
			cities[283] = "Stoneham";
			cities[284] = "Stoughton";
			cities[285] = "Stow";
			cities[286] = "Sturbridge";
			cities[287] = "Sudbury";
			cities[288] = "Sunderland";
			cities[289] = "Sutton";
			cities[290] = "Swampscott";
			cities[291] = "Swansea";
			cities[292] = "Taunton";
			cities[293] = "Templeton";
			cities[294] = "Tewksbury";
			cities[295] = "Tisbury";
			cities[296] = "Tolland";
			cities[297] = "Topsfield";
			cities[298] = "Townsend";
			cities[299] = "Truro";
			cities[300] = "Tyngsborough";
			cities[301] = "Tyringham";
			cities[302] = "Upton";
			cities[303] = "Uxbridge";
			cities[304] = "Wakefield";
			cities[305] = "Wales";
			cities[306] = "Walpole";
			cities[307] = "Waltham";
			cities[308] = "Ware";
			cities[309] = "Wareham";
			cities[310] = "Warren";
			cities[311] = "Warwick";
			cities[312] = "Washington";
			cities[313] = "Watertown";
			cities[314] = "Wayland";
			cities[315] = "Webster";
			cities[316] = "Wellesley";
			cities[317] = "Wellfleet";
			cities[318] = "Wendell";
			cities[319] = "Wenham";
			cities[320] = "West Boylston";
			cities[321] = "West Bridgewater";
			cities[322] = "West Brookfield";
			cities[323] = "West Newbury";
			cities[324] = "West Springfield";
			cities[325] = "West Stockbridge";
			cities[326] = "West Tisbury";
			cities[327] = "Westborough";
			cities[328] = "Westfield";
			cities[329] = "Westford";
			cities[330] = "Westhampton";
			cities[331] = "Westminster";
			cities[332] = "Weston";
			cities[333] = "Westport";
			cities[334] = "Westwood";
			cities[335] = "Weymouth";
			cities[336] = "Whately";
			cities[337] = "Whitman";
			cities[338] = "Wilbraham";
			cities[339] = "Williamsburg";
			cities[340] = "Williamstown";
			cities[341] = "Wilmington";
			cities[342] = "Winchendon";
			cities[343] = "Winchester";
			cities[344] = "Windsor";
			cities[345] = "Winthrop";
			cities[346] = "Woburn";
			cities[347] = "Worcester";
			cities[348] = "Worthington";
			cities[349] = "Wrentham";
			cities[350] = "Yarmouth";
			
				StringBuffer result = new StringBuffer("");

				for (String current : cities)  
				{
					if (current.contains(city))
					{
						
						result.append("<option value='"+current+"'>'"+current+"'</option>");
					}
				}
				
				
			return result.toString(); 
				
				
				
			}
			catch(Exception e){
				System.out.println("Error:" +e.getMessage() );
				return "null";
			}
			
		}
	
	
	
	
	
	
		//ajax call to populate countries
				@RequestMapping(value="/countries", method = RequestMethod.GET)
				public @ResponseBody String sendcountry(@RequestParam("country") String country){
					
					try{
						
						String [] countries = new String[258];

						countries[0] ="Algiers";

						countries[1]="Afghanistan";

						countries[2]="Akrotiri";

						countries[3]="Albania";

						countries[4]="Algeria";

						countries[5]="American Samoa";

						countries[6]="Andorra";

						countries[7]="Angola";

						countries[8]="Anguilla";

						countries[9]="Antarctica";

						countries[10]="Antigua and Barbuda";

						countries[11]="Argentina";

						countries[12]="Armenia";

						countries[13]="Aruba";

						countries[14]="Ashmore and Cartier Islands";

						countries[15]="Australia";

						countries[16]="Austria";

						countries[17]="Azerbaijan";

						countries[18]="Bahamas, The";

						countries[19]="Bahrain";

						countries[20]="Bangladesh";

						countries[21]="Barbados";

						countries[22]="Bassas da India";

						countries[23]="Belarus";

						countries[24]="Belgium";

						countries[25]="Belize";

						countries[26]="Benin";

						countries[27]="Bermuda";

						countries[28]="Bhutan";

						countries[29]="Bolivia";

						countries[30]="Bosnia and Herzegovina";

						countries[31]="Botswana";

						countries[32]="Bouvet Island";

						countries[33]="Brazil";

						countries[34]="British Indian Ocean Territory";

						countries[35]="British Virgin Islands";

						countries[36]="Brunei";

						countries[37]="Bulgaria";

						countries[38]="Burkina Faso";

						countries[39]="Burma";

						countries[40]="Burundi";

						countries[41]="Cambodia";

						countries[42]="Cameroon";

						countries[43]="Canada";

						countries[44]="Cape Verde";

						countries[45]="Cayman Islands";

						countries[46]="Central African Republic";

						countries[47]="Chad";

						countries[48]="Chile";

						countries[49]="China";

						countries[50]="Christmas Island";

						countries[51]="Clipperton Island";

						countries[52]="Cocos (Keeling) Islands";

						countries[53]="Colombia";

						countries[54]="Comoros";

						countries[55]="Congo, Democratic Republic of the";

						countries[56]="Congo, Republic of the";

						countries[57]="Cook Islands";

						countries[58]="Coral Sea Islands";

						countries[59]="Costa Rica";

						countries[60]="Cote d Ivoire";

						countries[61]="Croatia";

						countries[62]="Cuba";

						countries[63]="Cyprus";

						countries[64]="Czech Republic";

						countries[65]="Denmark";

						countries[66]="Dhekelia";

						countries[67]="Djibouti";

						countries[68]="Dominica";

						countries[69]="Dominican Republic";

						countries[70]="Ecuador";

						countries[71]="Egypt";

						countries[72]="El Salvador";

						countries[73]="Equatorial Guinea";

						countries[74]="Eritrea";

						countries[75]="Estonia";

						countries[76]="Ethiopia";

						countries[77]="Europa Island";

						countries[78]="Falkland Islands (Islas Malvinas)";

						countries[79]="Faroe Islands";

						countries[80]="Fiji";

						countries[81]="Finland";

						countries[82]="France";

						countries[83]="French Guiana";

						countries[84]="French Polynesia";

						countries[85]="French Southern and Antarctic Lands";

						countries[86]="Gabon";

						countries[87]="Gambia, The";

						countries[88]="Gaza Strip";

						countries[89]="Georgia";

						countries[90]="Germany";

						countries[91]="Ghana";

						countries[92]="Gibraltar";

						countries[93]="Glorioso Islands";

						countries[94]="Greece";

						countries[95]="Greenland";

						countries[96]="Grenada";

						countries[97]="Guadeloupe";

						countries[98]="Guam";

						countries[99]="Guatemala";

						countries[100]="Guernsey";

						countries[101]="Guinea";

						countries[102]="Guinea-Bissau";

						countries[103]="Guyana";

						countries[104]="Haiti";

						countries[105]="Heard Island and McDonald Islands";

						countries[106]="Holy See (Vatican City)";

						countries[107]="Honduras";

						countries[108]="Hong Kong";

						countries[109]="Hungary";

						countries[110]="Iceland";

						countries[111]="India";

						countries[112]="Indonesia";

						countries[113]="Iran";

						countries[114]="Iraq";

						countries[115]="Ireland";

						countries[116]="Isle of Man";

						countries[117]="Israel";

						countries[118]="Italy";

						countries[119]="Jamaica";

						countries[120]="Jan Mayen";

						countries[121]="Japan";

						countries[122]="Jersey";

						countries[123]="Jordan";

						countries[124]="Juan de Nova Island";

						countries[125]="Kazakhstan";

						countries[126]="Kenya";

						countries[127]="Kiribati";

						countries[128]="Korea, North";

						countries[129]="Korea, South";

						countries[130]="Kuwait";

						countries[131]="Kyrgyzstan";

						countries[132]="Laos";

						countries[133]="Latvia";

						countries[134]="Lebanon";

						countries[135]="Lesotho";

						countries[136]="Liberia";

						countries[137]="Libya";

						countries[138]="Liechtenstein";

						countries[139]="Lithuania";

						countries[140]="Luxembourg";

						countries[141]="Macau";

						countries[142]="Macedonia";

						countries[143]="Madagascar";

						countries[144]="Malawi";

						countries[145]="Malaysia";

						countries[146]="Maldives";

						countries[147]="Mali";

						countries[148]="Malta";

						countries[149]="Marshall Islands";

						countries[150]="Martinique";

						countries[151]="Mauritania";

						countries[152]="Mauritius";

						countries[153]="Mayotte";

						countries[154]="Mexico";

						countries[155]="Micronesia, Federated States of";

						countries[156]="Moldova";

						countries[157]="Monaco";

						countries[158]="Mongolia";

						countries[159]="Montserrat";

						countries[160]="Morocco";

						countries[161]="Mozambique";

						countries[162]="Namibia";

						countries[163]="Nauru";

						countries[164]="Navassa Island";

						countries[165]="Nepal";

						countries[166]="Netherlands";

						countries[167]="Netherlands Antilles";

						countries[168]="New Caledonia";

						countries[169]="New Zealand";

						countries[170]="Nicaragua";

						countries[171]="Niger";

						countries[172]="Nigeria";

						countries[173]="Niue";

						countries[174]="Norfolk Island";

						countries[175]="Northern Mariana Islands";

						countries[176]="Norway";

						countries[177]="Oman";

						countries[178]="Pakistan";

						countries[179]="Palau";

						countries[180]="Panama";

						countries[181]="Papua New Guinea";

						countries[182]="Paracel Islands";

						countries[183]="Paraguay";

						countries[184]="Peru";

						countries[185]="Philippines";

						countries[186]="Pitcairn Islands";

						countries[187]="Poland";

						countries[188]="Portugal";

						countries[189]="Puerto Rico";

						countries[190]="Qatar";

						countries[191]="Reunion";

						countries[192]="Romania";

						countries[193]="Russia";

						countries[194]="Rwanda";

						countries[195]="Saint Helena";

						countries[196]="Saint Kitts and Nevis";

						countries[197]="Saint Lucia";

						countries[198]="Saint Pierre and Miquelon";

						countries[199]="Saint Vincent and the Grenadines";

						countries[200]="Samoa";

						countries[201]="San Marino";

						countries[202]="Sao Tome and Principe";

						countries[203]="Saudi Arabia";

						countries[204]="Senegal";

						countries[205]="Serbia and Montenegro";

						countries[206]="Seychelles";

						countries[207]="Sierra Leone";

						countries[208]="Singapore";

						countries[209]="Slovakia";

						countries[210]="Slovenia";

						countries[211]="Solomon Islands";

						countries[212]="Somalia";

						countries[213]="South Africa";

						countries[214]="South Georgia and the South Sandwich Islands";

						countries[215]="Spain";

						countries[216]="Spratly Islands";

						countries[217]="Sri Lanka";

						countries[218]="Sudan";

						countries[219]="Suriname";

						countries[220]="Svalbard";

						countries[221]="Swaziland";

						countries[222]="Sweden";

						countries[223]="Switzerland";

						countries[224]="Syria";

						countries[225]="Taiwan";

						countries[226]="Tajikistan";

						countries[227]="Tanzania";

						countries[228]="Thailand";

						countries[229]="Timor-Leste";

						countries[230]="Togo";

						countries[231]="Tokelau";

						countries[232]="Tonga";

						countries[233]="Trinidad and Tobago";

						countries[234]="Tromelin Island";

						countries[235]="Tunisia";

						countries[236]="Turkey";

						countries[237]="Turkmenistan";

						countries[238]="Turks and Caicos Islands";

						countries[239]="Tuvalu";

						countries[240]="Uganda";

						countries[241]="Ukraine";

						countries[242]="United Arab Emirates";

						countries[243]="United Kingdom";

						countries[244]="United States";

						countries[245]="Uruguay";

						countries[246]="Uzbekistan";

						countries[247]="Vanuatu";

						countries[248]="Venezuela";

						countries[249]="Vietnam";

						countries[250]="Virgin Islands";

						countries[251]="Wake Island";

						countries[252]="Wallis and Futuna";

						countries[253]="West Bank";

						countries[254]="Western Sahara";

						countries[255]="Yemen";

						countries[256]="Zambia";

						countries[257]="Zimbabwe";

							  

						StringBuffer result = new StringBuffer("");

						for (String current : countries)  
						{
							if (current.contains(country))
							{
								
								result.append("<option value='"+current+"'>'"+current+"'</option>");
							}
						}
						
						
					return result.toString();
					
							
						
						
					}
					catch(Exception e){
						System.out.println("Error:" +e.getMessage() );
						return "null";
					}
					
				}
				
				
				
				//check if username password exists
				@RequestMapping(value="/upload", method = RequestMethod.POST)
				public String upload(@ModelAttribute("ride") Ride tempride, HttpServletRequest request)throws Exception
				{
					HttpSession session = request.getSession();
					Member member = (Member)session.getAttribute("member");
					
					

					
					
					
					Ride ride = rideDao.getRide(tempride.getRideId());
					//File localFile = new File("C:\\Users\\Neelu\\Documents\\workspace\\Bulleteers_Club\\src\\main\\webapp\\resources\\assets\\images\\", tempride.getRidePic().getOriginalFilename());

					try {
						//tempride.getRidePic().transferTo(localFile);
						ride.setRidePicPath("resources/assets/images/"+ tempride.getRidePic().getOriginalFilename());
						rideDao.updateRide(ride);
						
						
						
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} /*catch (IOException e) {
						e.printStackTrace();
					}*/
					
					
					Club club = memberDao.getClub(member);
					Set<Ride> rides = memberDao.getRide(club);
					
					session.setAttribute("member", member);
					session.setAttribute("club", club);
					session.setAttribute("rides", rides);
					
					return "memberhome";
					
				}
	
	
	
	
	
	
	

}
